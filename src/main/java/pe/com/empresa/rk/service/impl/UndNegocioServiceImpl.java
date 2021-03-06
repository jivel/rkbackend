package pe.com.empresa.rk.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.empresa.rk.domain.model.repository.jdbc.UndNegocioRepository;
import pe.com.empresa.rk.view.model.CargoViewModel;
import pe.com.empresa.rk.view.model.UndNegocioViewModel;
import pe.com.empresa.rk.service.UndNegocioService;

@Service
public class UndNegocioServiceImpl implements UndNegocioService{

	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	UndNegocioRepository undNegocioRepository; 
	
	@Override
	public List<UndNegocioViewModel> getUndNegocio() {
		return undNegocioRepository.findUndNegocio();
	}

	@Override
	public List<CargoViewModel> getListCargos() {
		// TODO Auto-generated method stub
		return undNegocioRepository.findListCargos();
	}
}
