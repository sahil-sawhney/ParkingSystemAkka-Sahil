import akka.actor.{Props, ActorSystem}

import scala.collection.mutable.ListBuffer

/**
  * Created by sahil on 3/16/16.
  */
object ParkingLotManagement {

  val parkingSystem = ActorSystem("ParkingLot")
  val attendant = parkingSystem.actorOf(Props[Attendant], "Attendant")
  val slotMonitor = parkingSystem.actorOf(Props[SlotMonitor], "SlotMonitor")

  val parkingSlots = ListBuffer(false, false, false, false, false)

  def main(args: Array[String]): Unit = {

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")

    attendant ! Ticket(2)

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")

    attendant ! Ticket(3)

    attendant ! Ticket(4)

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")

    attendant ! ParkingMessage("I Need Parking")


  }

  def findParkingSlot: Int = {

    parkingSlots.indexOf(false)
  }

  def assignParkingSlot(slot: Int): Unit = {

    parkingSlots(slot) = true
  }

  def freeSlot(slot: Int): Int = {

    parkingSlots(slot) = false
    slot + 1
  }

}
