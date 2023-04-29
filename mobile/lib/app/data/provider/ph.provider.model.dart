import 'package:app/app/data/base.url.dart';
import 'package:app/app/data/model/ph.model.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';

class PhApiClient extends DwGetConnect {
  find(int idinstallation) async {
    try {
      final response = await get(baseUrl + '/app/ph/$idinstallation');
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      return null;
    }
  }

  update(Ph ph) async {
    try {
      final response = await put(baseUrl + '/app/ph', ph.toJson());
      return response.statusCode == 202 ? response.body as List : null;
    } catch (e) {
      print(e);
      return null;
    }
  }
}
