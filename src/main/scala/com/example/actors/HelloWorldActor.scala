package com.example.actors

import akka.actor.{Actor, ActorLogging, Props}

class HelloWorldActor extends Actor with ActorLogging {

  override def preStart(): Unit = {
    // create the greeter actor
    val greeter = context.actorOf(Props[GreeterActor], "greeter")
    greeter ! GreeterMessages.Greet("Hello World!")
    // Send it the 'Greet' message
  }

  def receive = {
    // When we receive the 'Done' message, stop this actor
    // (which if this is still the initialActor will trigger the deathwatch and stop the entire ActorSystem)
    case GreeterMessages.Done =>
      context.stop(self)
  }
}

