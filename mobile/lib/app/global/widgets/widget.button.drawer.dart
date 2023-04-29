import 'package:flutter/material.dart';
import 'package:get/get.dart';

class DwFloatButtonRotas extends StatelessWidget {
  final Color corButton;
  final String label;
  final String subLabel;
  final Color labelCor;
  final String rotaOnPress;
  final bool isAnimation;
  final IconData icon;
  final Color corIcon;
  final Function fun;

  const DwFloatButtonRotas({
    Key key,
    this.icon = Icons.ac_unit,
    this.isAnimation,
    this.subLabel = '',
    this.label = "",
    this.rotaOnPress,
    this.labelCor,
    this.corButton,
    this.corIcon = Colors.white,
    this.fun,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(1.0),
      child: GestureDetector(
        onTap: fun ?? () => Get.toNamed(rotaOnPress),
        child: Container(
          width: Get.width,
          height: subLabel.length < 35 ? 55 : 55,
          decoration: BoxDecoration(
            color: corButton ?? Colors.blue[800],
            borderRadius: BorderRadius.circular(9),
          ),
          child: Row(
            children: [
              Expanded(
                flex: 1,
                child: Icon(icon, color: corIcon, size: 28),
              ),
              Expanded(
                flex: 5,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      label,
                      style: TextStyle(
                        fontSize: 15,
                        fontStyle: FontStyle.italic,
                        fontWeight: FontWeight.bold,
                        color: labelCor ?? Colors.black,
                      ),
                    ),
                    SizedBox(height: 3),
                    Text(
                      subLabel,
                      style: TextStyle(
                        fontSize: 12,
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
