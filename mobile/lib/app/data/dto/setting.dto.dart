import 'package:app/app/data/enum/setting.enum.dart';

class SettingDto {
  String title;
  bool enable;
  SettingEnum setting;

  SettingDto({
    this.title,
    this.setting,
    this.enable,
  });
}
