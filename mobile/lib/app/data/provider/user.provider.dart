import 'dart:convert';

import 'package:app/app/data/base.url.dart';
import 'package:app/app/data/model/user.model.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';

class UserApiClient extends DwGetConnect {
  auth(String username, String password) async {
    try {
      final response = await post(
          baseUrl + '/login', {"username": username, "password": password});
      return response.statusCode == 200 ? jsonDecode(response.body) : null;
    } catch (e) {
      print(e);
    }
  }

  // ignore: missing_return
  Future<Map<String, dynamic>> register(User user) async {
    try {
      final response = await post(baseUrl + '/user', user.toJson());
      return response.statusCode == 201 ? response.body : null;
    } catch (e) {
      print(e);
    }
  }

  logout() async {
    try {
      final response = await post(baseUrl + '/logout', {});
      return response.statusCode == 201 ? response.body : null;
    } catch (e) {
      print(e);
    }
  }
}
