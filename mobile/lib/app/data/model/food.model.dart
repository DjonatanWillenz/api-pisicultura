import 'dart:convert';

import 'package:app/app/data/enum/food.state.enum.dart';
import 'package:app/app/data/enum/ration.enum.dart';
import 'package:app/app/data/enum/run.enum.dart';

class Food {
  int id;
  FoodStateEnum state;
  DateTime dateCreate;
  DateTime dateConcluded;
  RationEnum ration;
  DateTime dateRunFeed;
  RunEnum run;

  Food({
    this.id,
    this.state,
    this.dateCreate,
    this.dateConcluded,
    this.ration,
    this.dateRunFeed,
    this.run,
  });

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'state': state,
      'dateCreate': dateCreate,
      'dateConcluded': dateConcluded,
      'ration': ration,
      'dateRunFeed': dateRunFeed,
      'run': run,
    };
  }

  static Food fromMap(Map<String, dynamic> map) {
    return Food(
      id: map['id'],
      state: map['state'],
      dateCreate: DateTime.parse(map['dateCreate']),
      dateConcluded: DateTime.parse(map['dateConcluded']),
      ration: map['ration'],
      dateRunFeed: DateTime.parse(map['dateRunFeed']),
      run: map['run'],
    );
  }

  String toJson() => json.encode(toMap());

  static fromJson(String source) => fromMap(json.decode(source));
}
