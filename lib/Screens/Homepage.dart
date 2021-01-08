import 'package:dropdown_formfield/dropdown_formfield.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Homepage extends StatefulWidget {
  @override
  _HomepageState createState() => _HomepageState();
}

class _HomepageState extends State<Homepage> {
  int selected_value;
  var data;

  static const androidMethodChannel =
  const MethodChannel('team.native.io/gps');

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(child: Center(
        child: Column(
          mainAxisSize: MainAxisSize.max,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              padding: EdgeInsets.all(16),
              child: DropDownFormField(
                titleText: 'Service',
                hintText: 'Please choose one',
                value: selected_value,
                onSaved: (value) {
                  setState(() {
                    selected_value = value;
                  });
                },
                onChanged: (value) {
                  setState(() {
                    selected_value = value;
                  });
                },
                dataSource: [
                  {
                    "display": "Get GPS",
                    "value": 1,
                  },
                  {
                    "display": "Capture Signature",
                    "value": 2,
                  },
                  {
                    "display": "Capture Barcode",
                    "value": 3,
                  },
                  {
                    "display": "Swimming",
                    "value": 4,
                  },
                  {
                    "display": "Detect Card",
                    "value": 5,
                  },
                  {
                    "display": "Record Voice",
                    "value": 6,
                  },
                  {
                    "display": "Record Video",
                    "value": 7,
                  },
                ],
                textField: 'display',
                valueField: 'value',
              ),
            ),
            Container(
              padding: EdgeInsets.all(8),
              child: RaisedButton(
                child: Text('Save'),
                onPressed: () async {
                  if(selected_value==1){
                    data = await androidMethodChannel
                        .invokeMethod('gps', {'filePath': ""});
                   print("return data  ${data}");
                  }
                },
              ),
            ),

            Text("${data}")
          ],
        ),
      )),
    );
  }
}
