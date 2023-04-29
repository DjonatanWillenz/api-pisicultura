import 'dart:convert';

class UserSetting {
  UserSetting({
    this.iduser,
    this.notify,
  });

  int iduser;
  bool notify;

  Map<String, dynamic> toMap() {
    return {
      'iduser': iduser,
      'notify': notify,
    };
  }

  factory UserSetting.fromMap(Map<String, dynamic> map) {
    return UserSetting(
      iduser: map['iduser'],
      notify: map['notify'],
    );
  }

  String toJson() => json.encode(toMap());

  factory UserSetting.fromJson(String source) =>
      UserSetting.fromMap(json.decode(source));
}
