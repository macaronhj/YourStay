package yourstay.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import yourstay.md.dao.interfaces.ReservationDAO;
import yourstay.md.domain.Reservation;
import yourstay.md.domain.resultVO;
import yourstay.md.mapper.SearchMapper;

@Controller
@RequestMapping("/res")
@Log4j
public class ReservationController {
	@Autowired
	ReservationDAO reservationDAO;
	@Autowired
	SearchMapper searchMapper;
	/*
	 * ���һ����������� ����� ���ð����� �Ѱܹ޾ƾ���
	 */
	@RequestMapping("/reservation.do")
	public ModelAndView reservation(Reservation reserv) {
		List<String> result = reservationDAO.addReservation(reserv); //result ����Ʈ�� 0��° ���� true�̸� ���డ�� false�̸� ���� �Ұ���
		if(result.get(0)=="TRUE") {
			//���డ��
		}else {
			//����Ұ�
		}
		return null;
	}
	/*
	 * ���һ󼼳��� ������ �̵�
	 */
	@PostMapping("/reservdetail")
	public ModelAndView reserdetailPage(@RequestParam Integer aid, @RequestParam String rstart, @RequestParam String rend, @RequestParam long resultprice, @RequestParam long days) {
		log.info("reserdetailPage : " + aid);
		log.info("ReservationCon reserdetailPage //// Integer aid : "  + aid+ ", startDate : "+ rstart+", endDate : "+ rend);
	      
		List<resultVO> rlist = searchMapper.getAccommodationByAccommodationId(aid);
		resultVO rVO = rlist.get(0);
		rVO.setRstart(rstart);//����ڼ��� ���۳�¥ ����
		rVO.setRend(rend);//����ڼ��� ����¥ ����
		rVO.setDays(days);//�����ϼ� ����
		rVO.setResultprice(resultprice); //���� �ݾ� ����
		rVO.setAid(aid);
		
		
		log.info("reserdetailPage resultVO: " + rVO.toString());
		return new ModelAndView("/reserdetail/reservation","rdetail",rVO);
	}
}
