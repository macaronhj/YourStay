package yourstay.md.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.WishListVO;
import yourstay.md.mapper.MyPageMapper;

@Service
public class MyPageServiceImpl implements MyPageService {
	@Autowired
	MyPageMapper myPageMapper;

	/*
	 * 회원의 찜정보뽑기
	 */
	@Override
	public List<WishListVO> getWishAidS(long mseq) {
		List<WishListVO> vo = myPageMapper.getWishAid(mseq);
		return vo;
	}

	/*
	 * 회원이 찜한 숙박업체 리스트
	 */
	@Override
	public List<Accommodation> getWishListS(List<WishListVO> wishlist) {
		List<Accommodation> vo = myPageMapper.getWishList(wishlist);
		return vo;
	}

	@Override
	public Map<String, List> getWishS(long mseq) {
		Map<String, List> wishMap = new HashMap<String, List>();

		List<WishListVO> wishList = myPageMapper.getWishAid(mseq);
		if (wishList.size() == 0) {
			return null;
		}

		List<Accommodation> accommoList = myPageMapper.getWishList(wishList);

		wishMap.put("wishList", wishList);
		wishMap.put("accommoList", accommoList);

		return wishMap;
	}

}
