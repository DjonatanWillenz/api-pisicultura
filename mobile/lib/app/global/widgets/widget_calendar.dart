import 'package:flutter/material.dart';

class DwCalendar extends StatelessWidget {
  final DateTime initialDate;
  final DateTime firstDate;
  final DateTime lastDate;
  final Function onDateChanged;

  const DwCalendar({
    Key key,
    this.initialDate,
    this.firstDate,
    this.lastDate,
    this.onDateChanged,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return CalendarDatePicker(
      initialDate: initialDate ?? DateTime.now(),
      firstDate: firstDate ?? DateTime.now(),
      lastDate: lastDate ?? DateTime.now(),
      onDateChanged: onDateChanged,
    );
  }
}
