int hash = 0;
for (int i = 0; i < length(); i++) {
  hash = (hash << 5) - hash + charAt(i);
}
return hash;