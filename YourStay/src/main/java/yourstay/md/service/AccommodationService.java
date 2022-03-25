package yourstay.md.service;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.Accomoption;
import yourstay.md.domain.Image;
import yourstay.md.domain.MemberVO;

public interface AccommodationService {
	/*
	 * 숙소 테이블에 등록
	 */
	public void insertAccommodationS(Accommodation ac);
	/*
	 * 숙소 옵션 테이블에 등록
	 */
	public void insertAccomoptionS(Accomoption aco);
	/*
	 * 숙소 옵션 정보들 가져오기
	 */
	public Accomoption getAccomoptionS(long aid);
	/*
	 * 이미지 테이블 등록
	 */
	public void insertImageS(Image img);
	/*
	 * 등록하는 회원번호 가져오기
	 */
	public MemberVO getRegisterMemberSeqS(long seq);
}
