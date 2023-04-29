import 'dart:convert';

import 'package:app/app/data/enum/run.enum.dart';

class Ph {
  int id;
  int idinstallation;
  double value;
  DateTime date;
  RunEnum run;

  Ph({
    this.id,
    this.idinstallation,
    this.value,
    this.date,
    this.run,
  });

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'idinstallation': idinstallation,
      'value': value,
      'date': date,
      'run': run,
    };
  }

  static Ph fromMap(Map<String, dynamic> map) {
    return Ph(
      id: map['id'],
      idinstallation: map['idinstallation'],
      value: map['value'],
      date: DateTime.parse(map['date']),
      run: map['run'],
    );
  }

  String toJson() => json.encode(toMap());

  static fromJson(String source) => fromMap(json.decode(source));
}
