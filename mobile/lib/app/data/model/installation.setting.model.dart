import 'dart:convert';

class InstallationSetting {
  String key;
  String value;

  InstallationSetting({
    this.key,
    this.value,
  });

  Map<String, dynamic> toMap() {
    return {
      'key': key,
      'value': value,
    };
  }

  factory InstallationSetting.fromMap(Map<String, dynamic> map) {
    return InstallationSetting(
      key: map['key'],
      value: map['value'],
    );
  }

  String toJson() => json.encode(toMap());

  factory InstallationSetting.fromJson(String source) =>
      InstallationSetting.fromMap(json.decode(source));
}
