package com.practice.loan.service;

import com.practice.loan.domain.Counsel;
import com.practice.loan.dto.CounselDTO.Request;
import com.practice.loan.dto.CounselDTO.Response;
import com.practice.loan.repository.CounselRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService {

  private final CounselRepository counselRepository;

  private final ModelMapper modelMapper;

  @Override
  public Response create(Request request) {
    Counsel counsel = modelMapper.map(request, Counsel.class);
    counsel.setAppliedAt(LocalDateTime.now());

    Counsel created = counselRepository.save(counsel);

    return modelMapper.map(created, Response.class);
  }
}