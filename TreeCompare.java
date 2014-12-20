public class TreeCompare{


	bool tree_compare (const node* t1, const node* t2)
{
  // Same node check - also handles both NULL case
  if (t1 == t2)  return true;

  // Gone past leaf on one side check
  if ((t1 == NULL) || (t2 == NULL))  return false;

  // Do data checks and recursion of tree
  return ((t1->data == t2->data) && tree_compare (t1->left,  t2->left )
                                 && tree_compare (t1->right, t2->right));
}


}