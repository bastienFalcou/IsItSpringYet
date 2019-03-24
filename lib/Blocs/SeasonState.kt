package Blocs

import 'package:equatable/equatable.dart';

abstract class SeasonState extends Equatable {}

class SeasonSpring extends SeasonState {
    @override
    String toString() => 'SeasonSpring';
}

class SeasonNotSpring extends SeasonState {
    @override
    String toString() => 'SeasonNotSpring';
}
