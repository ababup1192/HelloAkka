package com.example.actors

import akka.actor.{Actor, ActorLogging}

// Note: Usually the message object (GreeterMessages) and the actor class (GreeterActor) will be called the same thing (eg. Greeter)
object GreeterMessages {

  case class Greet(message: String)

  case object Done

}

class GreeterActor extends Actor with ActorLogging {

  def receive = {
    case GreeterMessages.Greet(message) =>
      log.info(message)
      sender() ! GreeterMessages.Done // Send the 'Done' message back to the sender
  }

}