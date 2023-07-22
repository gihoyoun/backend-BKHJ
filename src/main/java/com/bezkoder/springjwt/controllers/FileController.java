package com.bezkoder.springjwt.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bezkoder.springjwt.models.FileDB;
import com.bezkoder.springjwt.security.services.FileStorageService;

import Response.ResponseFile;
import Response.ResponseMessage;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class FileController {

  @Autowired
  private FileStorageService storageService;
  // 파일 업로드 
  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,
                                                    @RequestParam("boardId") Long boardId) {
    String message = "";
    try {
      FileDB fileDB = storageService.store(boardId, file);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }



  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
              .fromCurrentContextPath()
              .pathSegment("api", "auth", "files", String.valueOf(dbFile.getId()))
              .toUriString();

      return new ResponseFile(
              dbFile.getName(),
              fileDownloadUri,
              dbFile.getType(),
              dbFile.getData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFileById(@PathVariable Long id) {
    FileDB fileDB = storageService.getFile(id);


    if (fileDB != null) {
      return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
              .body(fileDB.getData());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }
  @GetMapping("/files/board/{boardId}")
  public ResponseEntity<List<FileDB>> getFilesByBoardId(@PathVariable Long boardId) {
    List<FileDB> files = storageService.getFilesByBoardId(boardId);
    return new ResponseEntity<>(files, HttpStatus.OK);
  }
  //파일 삭제 
  @DeleteMapping("/files/{id}")
  public ResponseEntity<String> deleteFile(@PathVariable Long id) {
    try {
      storageService.deleteFile(id);
      return ResponseEntity.ok("File deleted successfully");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete file");
    }
  }

}