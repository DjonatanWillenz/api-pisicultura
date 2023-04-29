import 'dart:convert';

import 'package:app/app/data/enum/run.enum.dart';
import 'package:app/app/data/enum/temperature.state.enu.dart';

class Temperature {
  int id;
  int idinstallation;
  TemperatureStateEnum state;
  RunEnum run;
  DateTime date;
  double value;

  Temperature({
    this.id,
    this.idinstallation,
    this.state,
    this.run,
    this.date,
    this.value,
  });

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'idinstallation': idinstallation,
      'state': state,
      'value': value,
      'date': date,
      'run': run,
    };
  }

  static Temperature fromMap(Map<String, dynamic> map) {
    return Temperature(
      id: map['id'],
      idinstallation: map['idinstallation'],
      state: map['state'],
      value: map['value'],
      date: DateTime.parse(map['date']),
      run: map['run'],
    );
  }

  String toJson() => json.encode(toMap());

  static fromJson(String source) => fromMap(json.decode(source));
}
