'''

vanessa/xman.py - Vanessa

Author: Abhay Arora (https://github.com/xabharo)

Copyright (c) 2015 XenonStack, LLP.
Licensed under Creative Commons Attribution-NonCommercial 2.0 Generic (CC BY-NC 2.0) license: https://creativecommons.org/licenses/by-nc/2.0/legalcode

'''

import sys
from vanessa import Vanessa

vanessa = Vanessa()

try:
    command = sys.argv[2]
except:
    command = None

if command == 'start':
    vanessa.run()

''' eof '''