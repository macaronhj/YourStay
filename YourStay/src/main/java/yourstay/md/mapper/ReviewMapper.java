package yourstay.md.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import yourstay.md.domain.reviewVO;

public interface ReviewMapper {
	public List<reviewVO> getReview(long renum);
	public reviewVO deleteReview();
	public reviewVO insertReview(ArrayList<MultipartFile> files, String review);
}
