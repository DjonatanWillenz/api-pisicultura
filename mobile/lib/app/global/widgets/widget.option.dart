import 'package:app/app/data/enum/setting.enum.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

// ignore: must_be_immutable
class DwOption extends StatefulWidget {
  final SettingEnum setting;
  final String title;
  final String description;
  final bool enabled;
  RxBool _enabled = false.obs;
  final Function onChange;

  DwOption({
    Key key,
    this.setting,
    this.title,
    this.description,
    this.enabled,
    this.onChange,
  }) : super(key: key) {
    _enabled.value = enabled;
  }

  @override
  State<DwOption> createState() => _DwOptionState();
}

class _DwOptionState extends State<DwOption> {
  @override
  Widget build(BuildContext context) {
    return Obx(
      () => Padding(
        padding: const EdgeInsets.all(1.0),
        child: Container(
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(12),
            color: Colors.blue,
            border: Border.all(width: 1),
          ),
          child: SwitchListTile.adaptive(
            title: Text(widget.title),
            value: widget._enabled.value,
            onChanged: (newValue) {
              widget.onChange(widget.setting, newValue);
              widget._enabled.value = newValue;
            },
          ),
        ),
      ),
    );
  }
}
