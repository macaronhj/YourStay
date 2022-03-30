package yourstay.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	//reservation
	private long rid;
	private long aid;
	private long mseq;
	private String rstart;
	private String rend;
	private int rpeople;
	private int price;
	//accommodation
    private String aname;
    private String aloc;
    private int aprice;
    //member
    private String mname;
    private String memail;
}
