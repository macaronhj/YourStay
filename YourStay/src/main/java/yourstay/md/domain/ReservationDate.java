package yourstay.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDate {
	private long rdid;
	private long rid;
	private long aid;
	private String rdate;
	
	public ReservationDate(long l, String rdate, int rid) {
		super();
		this.aid = l;
		this.rid = -1; //dummy, DB fill it by Sequence : RD_ID_AUTOINC
		this.rdate = rdate;
		this.rid = rid;
	}
}
