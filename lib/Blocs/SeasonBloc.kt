package Blocs

import 'dart:async';

import 'package:meta/meta.dart';
import 'package:bloc/bloc.dart';
import 'package:user_repository/user_repository.dart';

import 'package:flutter_login/authentication/authentication.dart';

class SeasonBloc extends Bloc<SeasonEvent, SeasonState> {
    final UserRepository userRepository;

    SeasonBloc({@required this.userRepository})
    : assert(userRepository != null);

    @override
    AuthenticationState get initialState => AuthenticationUninitialized();

    @override
    Stream<AuthenticationState> mapEventToState(
            AuthenticationState currentState,
    AuthenticationEvent event,
    ) async* {
        if (event is AppStarted) {
            final bool hasToken = await userRepository.hasToken();

            if (hasToken) {
                yield AuthenticationAuthenticated();
            } else {
                yield AuthenticationUnauthenticated();
            }
        }

        if (event is LoggedIn) {
            yield AuthenticationLoading();
            await userRepository.persistToken(event.token);
            yield AuthenticationAuthenticated();
        }

        if (event is LoggedOut) {
            yield AuthenticationLoading();
            await userRepository.deleteToken();
            yield AuthenticationUnauthenticated();
        }
    }
}