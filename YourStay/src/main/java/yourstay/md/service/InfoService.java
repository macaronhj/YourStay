package yourstay.md.service;

import yourstay.md.domain.Accommodation;

public interface InfoService {
	Accommodation selectAccommodation(long aid);
}
