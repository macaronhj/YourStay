package yourstay.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class reviewVO {
	private long renum;
	private long aid;
	private String mseq;
	private int point;
	private String review;
	private int rimg1;
	private int rimg2;
	private int rimg3;
}
