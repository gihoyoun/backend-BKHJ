package com.bezkoder.springjwt.security.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.springjwt.models.Board;
import com.bezkoder.springjwt.models.FileDB;
import com.bezkoder.springjwt.repository.FileDBRepository;

@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  public FileDB store(Long boardId, MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB fileDB = new FileDB();
    fileDB.setBoard(new Board(boardId));
    fileDB.setName(fileName);
    fileDB.setType(file.getContentType());
    fileDB.setData(file.getBytes());

    return fileDBRepository.save(fileDB);
  }

  public FileDB getFile(Long id) {
    return fileDBRepository.findById(id).get();
  }

  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }

  public List<FileDB> getFilesByBoardId(Long boardId) {
    return fileDBRepository.findByBoardId(boardId);
  }
  public void deleteFile(Long id) {
    fileDBRepository.deleteById(id);
  }

}
