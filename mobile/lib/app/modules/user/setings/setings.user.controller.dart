import 'package:app/app/data/dto/setting.dto.dart';
import 'package:app/app/data/enum/setting.enum.dart';
import 'package:app/app/data/repository/user.setting.repository.dart';
import 'package:app/app/global/singletons/setings.system.dart';
import 'package:flutter/cupertino.dart';
import 'package:get/get.dart';

class SetingsUserController extends GetxController {
  final repositoty = Get.find<UserSettingRepository>();
  final formKey = GlobalKey<FormState>();

  List<SettingDto> settings = [
    SettingDto(title: "Ph", setting: SettingEnum.NOTIFY, enable: true),
    SettingDto(title: "Temperature", enable: false),
    SettingDto(title: "Oxigenação", enable: true),
  ].obs;

  onChange(SettingEnum setting, bool newVal) {
    switch (setting) {
      case SettingEnum.NOTIFY:
        SettingsSystem.instance.setting.notify = newVal;
        break;
      default:
        break;
    }
    repositoty.update(SettingsSystem.instance.setting);
  }

  enabledOption(SettingEnum setting) {
    switch (setting) {
      case SettingEnum.NOTIFY:
        return SettingsSystem.instance.setting.notify;
        break;
      default:
        break;
    }
    return false;
  }
}
