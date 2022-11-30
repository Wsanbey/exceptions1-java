package model.entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Reservation 
{
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn2, Date checkOut2) 
	{
		this.roomNumber = roomNumber;
		this.checkIn = checkIn2;
		this.checkOut = checkOut2;
	}

	public Integer getRoomNuber() 
	{
		return roomNumber;
	}

	public void setRoomNuber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	/* 
	 * Classe deletadas pq existira uma classe responsavel
	 * Por manipular esse dados
	 * 
	 * public void setCheckOut(Date checkOut) 
	 * {
	 *	this.checkOut = checkOut;
	 * }
	 *
	 *  public void setCheckIn(Date checkIn) 
	 * {
	 *	this.checkIn = checkIn;
	 * }
	 * 
	*/
	
	public long duration() 
	{
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MICROSECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut)
	{
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override 
	public String toString()
	{	
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nigths";		
	}
}
 