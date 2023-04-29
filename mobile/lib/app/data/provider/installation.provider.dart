import 'package:app/app/data/base.url.dart';
import 'package:app/app/data/model/installation.model.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';

class InstallationApiClient extends DwGetConnect {
  find(int iduser) async {
    try {
      final response = await get(baseUrl + '/app/installation/$iduser');
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      return null;
    }
  }

  update(Installation setting) async {
    try {
      final response =
          await put(baseUrl + '/app/installation', setting.toJson());
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      print(e);
      return null;
    }
  }
}
