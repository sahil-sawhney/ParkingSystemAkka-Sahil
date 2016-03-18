import akka.actor.Actor

/**
  * Created by sahil on 3/16/16.
  */



class SlotMonitor extends Actor {

  def receive = {

    case message if message.isInstanceOf[ParkingMessage] && message.asInstanceOf[ParkingMessage].msg == "Alot Parking Spot"
    => sender ! ParkingLotManagement.findParkingSlot


    case ticket if ticket.isInstanceOf[Ticket] => sender ! ParkingLotManagement.freeSlot(ticket.asInstanceOf[Ticket].ticketNumber - 1)

  }
}
