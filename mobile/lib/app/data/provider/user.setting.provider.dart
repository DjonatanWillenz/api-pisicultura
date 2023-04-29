import 'package:app/app/data/base.url.dart';
import 'package:app/app/data/model/user.setting.model.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';

class UserSettingApiClient extends DwGetConnect {
  update(UserSetting setting) async {
    try {
      final response =
          await put(baseUrl + '/app/user-setting', setting.toJson());
      return response.statusCode == 201 ? response.body : null;
    } catch (e) {
      print(e);
    }
  }

  find(int id) async {
    try {
      final response =
          await get(baseUrl + '/app/user-setting/' + id.toString());
      return response.statusCode == 200 ? response.body : null;
    } catch (e) {
      print(e);
    }
  }
}
