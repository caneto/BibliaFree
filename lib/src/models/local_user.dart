import 'dart:convert';

class LocalUser {
  String firstName;
  String lastName;
  DateTime birthDate;

  LocalUser({
    this.firstName,
    this.lastName,
    this.birthDate,
  });

  LocalUser copyWith({
    String firstName,
    String lastName,
    String email,
    DateTime birthDate,
  }) {
    return LocalUser(
      firstName: firstName ?? this.firstName,
      lastName: lastName ?? this.lastName,
      birthDate: birthDate ?? this.birthDate,
    );
  }

  Map<String, dynamic> toMap() {
    return {
      'firstName': firstName,
      'lastName': lastName,
      'birthDate': birthDate.millisecondsSinceEpoch,
    };
  }

  factory LocalUser.fromMap(Map<String, dynamic> map) {
    return LocalUser(
      firstName: map['firstName'],
      lastName: map['lastName'],
      birthDate: DateTime.fromMillisecondsSinceEpoch(map['birthDate']),
    );
  }

  String toJson() => json.encode(toMap());

  factory LocalUser.fromJson(String source) => LocalUser.fromMap(json.decode(source));

  @override
  String toString() {
    return 'LocalUser(firstName: $firstName, lastName: $lastName, birthDate: $birthDate)';
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;

    return other is LocalUser &&
        other.firstName == firstName &&
        other.lastName == lastName &&
        other.birthDate == birthDate;
  }

  @override
  int get hashCode {
    return firstName.hashCode ^ lastName.hashCode ^ birthDate.hashCode;
  }
}
