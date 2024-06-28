package com.anyday.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "USER_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  @Id
  @UuidGenerator
  @Column(unique = true, nullable = false)
  private String uid;

  @Column(nullable = false)
  String guid;

  @Column(nullable = false)
  String juid;

  @Column(unique = true, nullable = false)
  String email;

  String firstName;
  String lastName;

  Date createdAt;
  Date lastModified;
}
