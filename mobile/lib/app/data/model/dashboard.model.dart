import 'dart:convert';
import 'package:get/get.dart';

class Dashboard {
  RxDouble temperature;
  RxDouble ph;
  RxDouble oxygenation;
  RxInt notifications;

  static init() {
    return new Dashboard(
      temperature: RxDouble(0),
      notifications: RxInt(0),
      oxygenation: RxDouble(0),
      ph: RxDouble(0),
    );
  }

  Dashboard({this.temperature, this.notifications, this.oxygenation, this.ph});

  Map<String, dynamic> toMap() {
    return {
      'temperature': temperature,
      'oxygenation': oxygenation,
      'ph': ph,
      'notifications': notifications,
    };
  }

  static Dashboard fromMap(Map<String, dynamic> map) {
    return Dashboard(
      temperature: map['temperature'],
      oxygenation: map['oxygenation'],
      ph: map['ph'],
      notifications: map['notifications'],
    );
  }

  String toJson() => json.encode(toMap());

  static fromJson(String source) => fromMap(json.decode(source));
}
