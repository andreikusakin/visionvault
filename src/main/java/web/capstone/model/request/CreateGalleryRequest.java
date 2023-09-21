package web.capstone.model.request;

import java.util.List;

public class CreateGalleryRequest {

  private Long userId;

  private String name;

  private String password;

  private String description;

  private List<String> pictures;

  public CreateGalleryRequest(
      Long userId, String name, String password, String description, List<String> pictures) {
    this.userId = userId;
    this.name = name;
    this.password = password;
    this.pictures = pictures;
    this.description = description;
  }

  public CreateGalleryRequest() {}

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<String> getPictures() {
    return pictures;
  }

  public void setPictures(List<String> pictures) {
    this.pictures = pictures;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
