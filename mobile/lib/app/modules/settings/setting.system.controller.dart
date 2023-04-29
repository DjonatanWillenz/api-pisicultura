import 'package:app/app/data/dto/setting.dto.dart';
import 'package:app/app/data/enum/setting.enum.dart';
import 'package:app/app/global/singletons/setings.system.dart';
import 'package:get/get.dart';

class SettingSystemController extends GetxController {
  List<SettingDto> settings = [
    SettingDto(title: "Ph", setting: SettingEnum.NOTIFY, enable: true),
    SettingDto(title: "Temperature", enable: false),
    SettingDto(title: "Oxigenação", enable: true),
  ].obs;

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

  onChanged(id, key, value) {
    print('id $id key: $key value: ');
  }
}
