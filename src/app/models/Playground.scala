package com.bsun.playground.models

import scala.concurrent.Future
import play.api.libs.json._

object Playground {

  def fakeDBCallToGetNumber(): Future[Int] = {
    Future.successful(12345)
  }

  def fakeDbCalltoMaybeNumber(): Future[Option[Int]] = {
    Future.successful(Option(12345))
  }

  def fakeDbCalltoGetStringFromNumber(number: Int): Future[Option[String]] = {
    Future.successful(Option("wooooot"))
  }

  def fakeFBApiCallToGetJsonBlobFromUsername(userName: String): Future[Option[JsObject]] = {
    Future.successful(Option(
      Json.obj(
        "userId" -> "lkjh345jkh34"
      )
    ))
  }

  def isNumPositive(num: Int): Boolean = {
    num > 0
  }


  /**
    * Iterate with map and return list of string lengths
    */
  def iterateWithMap() = {
    // 1. Declare a list of strings, add type to declaration

    // 2. Use longhand "map" to iterate the list and get length of each string

    // 3. Use shorthand "map" to do the same thing

    // 3. Return this list of Ints

    // 4. Add return type to method

  }

  /*
      Solution:

      def iterateWithMap(): List[Int] = {

        val stringList: List[String] = List("abc", "blah", "scalaIsAwesome")

        // longhand
        val longHand: List[Int] = stringList.map { str =>
          str.length
        }

        // shorthand: anytime you see "a => a", this can always be condensed to "_"
        stringList.map(_.length)
      }
   */




  /**
    * Convert a Map of (Int -> String) to map of (Int -> JsError)
    *
    * To instantiate a JsError: JsError(someString)
    */
  def convertMap() = {

    // 1. Starting map
    val startMap: Map[Int, String] = Map(
      123 -> "First Error",
      543 -> "Second Error",
      879 -> "Third Error"
    )

    // 2. convert

    // 3. determine return type

  }

  /*
     Solution:

     def convertMap(): Map[Int, JsError] = {
       val startMap: Map[Int, String] = Map(
         123 -> "First Error",
         543 -> "Second Error",
         879 -> "Third Error"
       )

       startMap.map { blah =>
         blah._1 -> JsError(blah._2)
       }
     }
  */


  /**
    * Filter a Future[List[Int]]
    */
  def filterFutureList() = {
    // 1. Starting list
    val startListFut = Future.successful(List(31, -5, 8, -99 , 98))

    // 2. Long hand filter to just positive values

    // 3. Short hand filter to just even values

    // 4. Determine return type
  }

  /*
    Solution:

    def filterFutureList(): Future[List[Int]] = {

      val startListFut = Future.successful(List(31, -5, 8, -99 , 98))

      val test = startListFut.map { startList =>
        startList.filter(num => isNumPositive(num))
      }

      startListFut.map(_.filter(_ % 2 == 0))
    }
  */

  /**
    * Unwrap a Future[Int]
    *
    * Check if a number from a DB call is odd. If it's odd, return true, otherwise return None.
    * Use the above fakeDBCallToGetNumber() as your fake DB call
    */
  def checkIfDbOdd() = {
    // 1. check if a number from a DB call is odd, using the above fakeDBCallToGetNumber() as your fake DB call


    // 2. If it's odd, return true, otherwise return None. (This mean your return type can't just be Boolean)


    // 3. Add return type


  }

  /*
     Solution:

     def checkIfDbOdd(): Future[Option[Boolean]] = {
       fakeDBCallToGetNumber().map { num =>
         if (num % 2 == 1) {
           Some(true)
         } else {
           None
         }
       }
     }
  */

  /**
    * Unwrap a Future[Option[Int]]
    */
  def checkIfOdd() = {
    // 1. check if a number from DB call exists, using the above fakeDbCalltoMaybeNumber() as your fake DB call


    // 2. If it exists and is odd, return true. Return false otherwise


    // 3. Add return type


  }

  /*
     Solution:

       def checkIfDbOdd(): Future[Boolean] = {
         fakeDbCalltoMaybeNumber().map { _ match {
           case Some(num) if num % 2 == 1 => true
           case _ => false
         }}
       }

       // You can also do shorthand way of doing a "match": (No need for "_ match")
       fakeDbCalltoMaybeNumber().map {
         case Some(num) if num % 2 == 1 => true
         case _ => false
       }

  */

  /**
    * Unwrap a Future[Future[Future[Either[JsError, JsObject]]]]
    *
    */
  def getFBJson() = {
    // 1. Use the above fakeDBCallToGetNumber() to get a number


    // 2. Use the number from 1. to call fakeDbCalltoGetStringFromNumber() and get a string


    // 3. Use the string from 2. to call fakeFBApiCallToGetJsonBlobFromUsername() to get json.


    // 4. If we don't get a json by the end, return JsError. Otherwise return the json


    // 5. Add return type
  }

  /*

    Solution:

    def getFBJson(): Future[Either[JsError, JsObject]] = {

      // call Db to get a number
      fakeDBCallToGetNumber().flatMap { myNum =>
        fakeDbCalltoGetStringFromNumber(myNum).flatMap {
          case Some(someString) => {
            fakeFBApiCallToGetJsonBlobFromUsername(someString).map {
              case Some(json) => {
                Right(json)
              }
              case None => {
                Left(JsError("no json found"))
              }
            }
          }
          case None => {
            Future.successful(Left(JsError("no json found")))
          }
        }
      }
    }
  */
}
