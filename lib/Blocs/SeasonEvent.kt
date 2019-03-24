package Blocs

import 'package:meta/meta.dart';
import 'package:equatable/equatable.dart';

abstract class SeasonEvent extends Equatable {
    SeasonEvent([List props = const []]) : super(props);
}

class SpringStarted extends SeasonEvent {
    @override
    String toString() => 'SpringStarted';
}

class SpringEnded extends SeasonEvent {
    @override
    String toString() => 'SpringEnded';
}
