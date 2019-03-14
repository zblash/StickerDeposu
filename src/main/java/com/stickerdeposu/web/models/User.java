package com.stickerdeposu.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotNull
        @Size(min = 3,max = 25)
        private String userName;

        @Email
        @NotNull
        private String email;

        @NotNull
        @Size(min = 3,max = 25)
        private String firstName;

        @NotNull
        @Size(min = 3,max = 25)
        private String lastName;

        @NotNull
        @Size(min = 5,max = 90)
        private String password;

        private String resetToken;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_role",
                joinColumns =
                @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns =
                @JoinColumn(name = "role_id", referencedColumnName = "id"))
        private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.LAZY)
        private Set<Address> addresses;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    public void addRole(Role role){
        roles.add(role);
    }

    public void removeRole(Role role){
        roles.remove(role);
    }


    public void addAddress(Address address){
        addresses.add(address);
    }

    public void removeAddress(Address address){
        addresses.remove(address);
    }

    public User() {
    }

    public User(@NotNull @Size(min = 3, max = 25) String userName, @Email @NotNull String email, @NotNull @Size(min = 3, max = 25) String firstName, @NotNull @Size(min = 3, max = 25) String lastName, @NotNull @Size(min = 5, max = 90) String password, String resetToken, Set<Role> roles, Set<Address> addresses, Cart cart) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.resetToken = resetToken;
        this.roles = roles;
        this.addresses = addresses;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
