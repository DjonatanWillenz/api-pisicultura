import 'dart:convert';

class Installation {
  int id;
  //List<InstallationSetting> settings;
  String name;
  String key;
  String description;
  DateTime dateCreate;
  bool active;

  Installation({
    this.id,
    this.name,
    this.key,
    this.description,
    this.dateCreate,
    this.active,
  }) {
    //  settings = new InstallationSetting(key: , value: '22');
  }

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'key': key,
      'description': description,
      'dateCreate': dateCreate,
      'active': active,
    };
  }

  static Installation fromMap(Map<String, dynamic> map) {
    Installation result = new Installation(
      id: map['id'],
      name: map['name'],
      key: map['key'],
      description: map['description'],
      dateCreate: DateTime.parse(map['dateCreate']),
      active: map['active'],
    );
    return result;
  }

  String toJson() => json.encode(toMap());

  static fromJson(String source) => fromMap(json.decode(source));
}
