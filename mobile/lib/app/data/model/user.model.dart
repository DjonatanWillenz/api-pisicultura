import 'dart:convert';

class User {
  int id;
  String name;
  String email;
  String username;
  String password;
  DateTime dataCreate;
  DateTime dataUpdate;
  String phone;
  bool isActive;
  String token;

  User({
    this.id,
    this.name,
    this.email,
    this.username,
    this.password,
    this.dataCreate,
    this.dataUpdate,
    this.phone,
    this.isActive,
    this.token,
  });

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'username': username,
      'email': email,
      'password': password,
      'dataCreate': dataCreate,
      'dataUpdate': dataUpdate,
      'phone': phone,
      'isActive': isActive,
      'token': token,
    };
  }

  factory User.fromMap(Map<String, dynamic> map) {
    return User(
      id: map['id'],
      name: map['name'],
      username: map['username'],
      email: map['email'],
      password: map['password'],
      dataCreate: map['dataCreate'],
      dataUpdate: map['dataUpdate'],
      phone: map['phone'],
      isActive: map['isActive'],
      token: map['token'],
    );
  }

  String toJson() => json.encode(toMap());

  factory User.fromJson(String source) => User.fromMap(json.decode(source));
}
