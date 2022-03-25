package yourstay.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {
	private long aid;
	private String aname;
	private String aloc;
	private long aprice;
	private long apoint;
	private String atype;
	private int apeople;
	private int iid;
	private long mseq;
	private String anotice;
}
