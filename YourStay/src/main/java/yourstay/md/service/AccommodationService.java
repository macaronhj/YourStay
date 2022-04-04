package yourstay.md.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.Image;
import yourstay.md.domain.MemberVO;
import yourstay.md.domain.roomRegisterVO;

public interface AccommodationService {
   /*
    * 숙소 테이블에 등록
    */
   public void insertAccommodationS(roomRegisterVO roomregisterVo, MultipartHttpServletRequest mpRequest) throws Exception;
   /*
    * 숙소 테이블 수정
    */
   public void updateAccommodationS(roomRegisterVO roomregisterVo, MultipartHttpServletRequest mpRequest) throws Exception;
   
   public String requestDelete(long aid);
   
   /*
    * 등록하는 회원번호 가져오기
    */
   public MemberVO getRegisterMemberSeqS(long seq);
}