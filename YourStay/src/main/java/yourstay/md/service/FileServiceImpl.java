package yourstay.md.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import yourstay.md.domain.reviewVO;
import yourstay.md.fileset.FileUtils;
import yourstay.md.mapper.ReviewMapper;

@Service
public class FileServiceImpl implements FileService {
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Inject
	private ReviewMapper mapper;
	
	@Override
	public void write(reviewVO reviewVo, MultipartHttpServletRequest mpRequest) throws Exception {
		mapper.insert(reviewVo);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(reviewVo, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			mapper.insertFile(list.get(i)); 
		}
	}

}
