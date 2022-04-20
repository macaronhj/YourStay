package yourstay.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCheck {
	//reservation
		private long rid;
		private long aid;
		private long mseq;
		private String rstart;
		private String rend;
		private int rpeople;
		private int rprice;
		private int checkView;
		private int checkView2;
		private int raccept;
		//accommodation
	    private String aname;
	    private String aloc;
	    private int aprice;
}
