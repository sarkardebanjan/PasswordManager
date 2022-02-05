package com.elite.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SERVICE_DATA")
@Cacheable(value = false)
public class ServiceData {

    @Id
    @Column(name = "SERVICE")
    private String service;

    @Column(name = "USERNAME1")
    private String username1;

    @Column(name = "USERNAME2")
    private String username2;

    @Column(name = "USERNAME3")
    private String username3;

    @Column(name = "USERNAME4")
    private String username4;

    @Column(name = "USERNAME5")
    private String username5;

    @Column(name = "PASSWORD1")
    private String password1;

    @Column(name = "PASSWORD2")
    private String password2;

    @Column(name = "PASSWORD3")
    private String password3;

    @Column(name = "PASSWORD4")
    private String password4;

    @Column(name = "PASSWORD5")
    private String password5;

    @Column(name = "RECOVERY_PHRASE")
    private String recoveryPhrase;

    @Column(name = "COMMENTS")
    private String comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceData that = (ServiceData) o;
        return service.equals(that.service) && Objects.equals(username1, that.username1) && Objects.equals(username2, that.username2) && Objects.equals(username3, that.username3) && Objects.equals(username4, that.username4) && Objects.equals(username5, that.username5) && Objects.equals(password1, that.password1) && Objects.equals(password2, that.password2) && Objects.equals(password3, that.password3) && Objects.equals(password4, that.password4) && Objects.equals(password5, that.password5) && Objects.equals(recoveryPhrase, that.recoveryPhrase) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service, username1, username2, username3, username4, username5, password1, password2, password3, password4, password5, recoveryPhrase, comments);
    }
}
