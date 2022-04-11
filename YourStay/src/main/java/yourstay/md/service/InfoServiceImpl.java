package yourstay.md.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yourstay.md.mapper.InfoMapper;
import yourstay.md.domain.Accommodation;


@Service
@AllArgsConstructor
public class InfoServiceImpl implements InfoService {
	private InfoMapper infoMapper;
	
	/*
	 * ���ҹ�ȣ�� �ش��ϴ� ������������ ����
	 */
	@Override
	public Accommodation selectAccommodation(long aid) {
		Accommodation acomm = infoMapper.selectByaid(aid);
		return acomm;
	}

}
